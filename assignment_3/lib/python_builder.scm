;; python_builder.scm
;;
;; CHICKEN Scheme API for python building

;; FIXME: order the output like this:
;;      1. module & defaults
;;      2. plants
;;      3. actions
;;      4. observers
;;      5. assets
;;      6. controllers

;; TODO: module & defaults
#|
Module : { TEST_GARLIC_ACTIONS_ASSETS_OBSERVERS_CONTROLLERS }
|#
;; -->
#|
% test_garlic_actions_assets_observers_controllers.py
# Automatically compiled Python module for:
# Module: TEST_GARLIC_ACTIONS_ASSETS_OBSERVERS_CONTROLLERS

####################
# Standard Imports #
####################

from abc import ABC, abstractmethod
from dataclasses import dataclass
from typing import Any, List, Dict, Callable

#########################
# Defaults & Constructs #
#########################

@dataclass
class UnitNumber:
    value: float
    unit: str

class Plant:
    pass

@dataclass
class Sensor:
    trigger: str
    action: Callable

    def check(self):
        print(f"Sensor trigger: {self.trigger}")
        self.action()

@dataclass
class Observer:
    address: str

class Observable:
    sensors: Dict[str, Sensor]

class Asset:
    pass

class Plantation(Asset, Observable):
    pass

class WaterSource(Asset, Observable):
    pass

class Controller(ABC):
    @abstractmethod
    def bootstrap(self):
        pass

    @abstractmethod
    def run(self):
        pass

######################
# Built-in Utilities #
######################

@dataclass
class MonitorController(Controller):
    assets: List[Asset]
    __triggers = {}

    def __register_trigger(self, trigger, sensor):
        self.__triggers = {
            trigger: sensor,
            **self.__triggers
        }

    def bootstrap(self):
        print("Setting up the controller...")
        for asset in self.assets:
            for key, sensor in asset.sensors.items():
                self.__register_trigger(sensor.trigger, sensor)

    def run(self):
        triggers = self.__triggers.keys()
        print(f"Registered monitor triggers: {triggers}")
        for trigger, sensor in self.__triggers.items():
            print(f"Assume trigger happened: {trigger}...")
            sensor.check()

def Action_send_message(*args):
    def __internal_function__():
        message_body = ";;;".join([str(a) for a in args])
        print(f"INCOMING MESSAGE: {message_body}")
    return __internal_function__

###################
# Module contents #
###################
|#
 
;; TODO: plants
#|
Plants : {
    Garlic <<
        approx_volume : 1 \cm^2,
        water_use : 5 \mm,
        min_temp  : 20 \C,
        max_water : 100,
    >>
}
|#
;; -->
#|

# Plants
# ~~~~~~~

class Garlic(Plant):
    approx_volume = UnitNumber(1, "\cm^2")
    water_use = UnitNumber(5, "\mm")
    min_temp = UnitNumber(20, "\C")
    max_water = UnitNumber(100, "\C")

PLANTS = [Garlic]
|#

;; TODO: actions
#|
Actions : {
    notify <<%src, channels>> (
        channels @> {c | send_message : {c, "regular update", %src}};
    )
}
|#
;; -->
#|

# Actions
# ~~~~~~~

@dataclass
class Action_notify:
    s_src: Any
    channels: Any

    def __call__(self):
        list(map(lambda c: Action_send_message(c, "regular_update", self.s_src)(), self.channels))

ACTIONS = [Action_notify]
|#

;; TODO: assets
;; FIXME: add "defferred" action syntax or flag??
#|
Assets : {
    garlic_north : Plantation <<Garlic>> : {
        // This is a comment
        desc: "Garlic plants on the north edge",
        area: 300 \m^2,
        plantation_date: "2022-11-02",
        sensors : { 
            water_level : Sensor : {
                "daily 9 am",
                notify : { [support] }
            },
            temp_level : Sensor : {
                "daily 9 am",
                notify : { [support, admin] }
            }
        }
    },
    water_tank : WaterSource : {
        installation_date: "2020-02-02",
        max_temp: 60 \C, 
        capacity: 30 \l,
        sensors : {
            water_level : Sensor : {
                "every 10 min", 
                notify : { [ support, admin, rss ] }
            }
        }
    }
}
|#
;; -->
#|

# Assets
# ~~~~~~

class Asset_garlic_north(Plantation, Garlic):
    def __init__(self):
        self.desc = "Garlic plants on the north edge"
        self.area = UnitNumber(300, "\m^2")
        self.plantation_date = "2022-11-02"
        self.sensors = {
            "water_level": Sensor(
                "daily 9 am", 
                Action_notify(self, [support, admin])
            )
        }
garlic_north = Asset_garlic_north()

class Asset_water_tank(WaterSource):
    def __init__(self):
        self.installation_date = "2020-02-02"
        self.max_temp = UnitNumber(60, "\C") 
        self.capacity = UnitNumber(30, "\l")
        self.sensors = {
            "water_level": Sensor(
                "daily 10 am", 
                Action_notify(self, [ support, admin, rss ])
            )
        }
water_tank = Asset_water_tank()

ASSETS = [garlic_north, water_tank]
|#

;; TODO: observers
#|
Observers : {
    support << "support@farm.cool" >>, 
    admin << "admin@farm.cool" >>, 
    rss << "farm.feed.rss" >>,
    abie << "abie@service.farm.cool" >>
}
|#
;; -->
#|

# Observers
# ~~~~~~~~~

support = Observer("support@farm.cool")
admin = Observer("admin@farm.cool")
rss = Observer("farm.feed.rss")
abbie = Observer("abie@service.farm.cool")

OBSERVERS = [support, admin, rss, abbie]
|#

;; TODO: controllers
#|
Controllers: {
    MONITOR
}
|#
;; -->
#|

# Controllers
# ~~~~~~~~~~~

MONITOR = MonitorController(ASSETS)
CONTROLLERS = [MONITOR]

# FIXME: add support for parallel processing
def main():
    # bootstrap controllers
    for controller in CONTROLLERS:
        controller.bootstrap()
    # run controllers
    for controller in CONTROLLERS:
        controller.run()


if __name__ == "__main__":
    main()
|#