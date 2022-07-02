# Declaring Assets in AIL

Example:

```plaintext
Assets : {
    ^^ desc: “Strawberry fruits along the South border”.
    ^^ area: 300 m^2.
    ^^ plantation_date: 2022-03-02.
    strawberry_plants : Plantation<Strawberry> : {
        sensors : {
            water_level : Sensor<
                “daily 9 am”,
                check_water : { > 30 mm, notify : {@ support.} }
            >
        }
    },
    ^^ installation_date: 2020-02-02.
    water_tank : WaterSource : {
        max_temp: 60 C, 
        capacity: 30 l,
        sensors : {
            water_level : Sensor : {
                “every 10 min”, 
                check_water : {
                    > 50 mm,
                    notify : {@ support, admin, rss.} 
                }
            }, 
            water_temp : Sensor : {
                “every 5 min”,
                check_avg_temp : {
                    > %src.max_temp,
                    notify : {Channels #> {c | c ~~ “abie”}}.
                }
            }
        }
    }
}
```

## Concrete syntax

### Top level assets collection

```plaintext
<<ASSET_DECLARATIONS>>  := "Assets : {" {<<ASSET_CONFIG>> ","}* "}"
```

### Individual asset config

> For `<<ATTRIBUTE>>` see [basics.md](./basics.md)
> For `<<TRIGGER_VALUE>>` see [scheduling.md](./scheduling.md)
> For `<<ACTION_SETUP>>` see [actions.md](./actions.md)

```plaintext
<<ASSET_CONFIG>>        := <<ASSET_IDENTIFIER>> ":" <<ASSET_TYPE>> ": {" <<ASSET_ATTRIBUTES>> "}
<<ASSET_IDENTIFIER>>    := <<IDENTIFIER>>
<<ASSET_ATTRIBUTES>>    := {<<ASSET_ATTRIBUTE>> ","}*
<<ASSET_ATTRIBUTE>>     := <<ATTRIBUTE>> | "sensors : {" <<SENSOR_CONFIG>> "}"
<<SENSOR_CONFIG>>       := <<SENSOR_IDENTIFIER>> ":" <<SENSOR_TYPE>> ": {" <<SENSOR_ATTRIBUTES>> "}
<<SENSOR_IDENTIFIER>>   := <<IDENTIFIER>>
<<SENSOR_TYPE>>         := "Sensor"
<<SENSOR_ATTRIBUTES>>   := {<<SENSOR_ATTRIBUTE>> ","}*
<<SENSOR_ATTRIBUTE>>    := <<TRIGGER_VALUE>> | <<ACTION_SETUP>>
```

#### Remarks

- Only one `<<SENSOR_TYPE>>` is currently supported - `"Sensor"`. This is intended for an ease of extension.
