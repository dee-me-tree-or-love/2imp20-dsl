# Declaring Scheduled executions in AIL

Example:

```plaintext
Controllers: {
    MONITOR,
}
```

## Top level controllers declaration

```f#
<<CONTROLLER_DECLARATIONS>>     := "Controllers : {" {<<CONTROLLER_CONFIG>> ","}* "}"
<<CONTROLLER_CONFIG>>           := <<CONTROLLER_IDENTIFIER>>
```

### Built-in controllers

> `MONITOR` controller is there to perform scheduled actions.  

```f#
<<CONTROLLER_IDENTIFIER>>       := "MONITOR"
```

## Action triggers for the controlers

[`Actions`](./actions.md) can be scheduled for a [`Sensor`](./assets.md).

Example

```plaintext
    ...
    sensors : {
        water_level : Sensor : {
            "daily 9 am",
            check_water : { > 30 mm, notify : { [support] } }
        }
    }
    ...
```

### CRON triggers

Examples:

```plaintext
0 * * * *
5 0 * 8 *
*/5 1,2,3 * * *
```

#### Concrete syntax fron CRON triggers

> Based on the [Vixie CRON specification](https://man7.org/linux/man-pages/man5/crontab.5.html).  
> For `<<NATURAL_NUMBER>>` see [basics](./basics.md).  

```f#
<<TRIGGER_SPEC>>            := <<CRON_TRIGGER>>
<<CRON_TRIGGER>>            := <<CRON_MINUTE>> <<CRON_HOUR>> <<CRON_MONTH_DAY>> <<CRON_MONTH>> <<CRON_WEEK_DAY>>

<<CRON_ANY_VALUE>>          := "*"
<<CRON_NUMBER_0_59>>        := [0-59]
<<CRON_NUMBER_0_23>>        := [0-23]
<<CRON_NUMBER_1_31>>        := [1-31]
<<CRON_NUMBER_1_12>>        := [1-12]
<<CRON_NUMBER_0_7>>         := [0-7]
<<CRON_NUMBER_DAYS>>        := "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" | "Saturday" | "Sunday"
                                | "mon" | "tue" | "wed" | "thu" | "fri" | "sat" | "sun"

<<CRON_MINUTE_BASE>>        := <<CRON_NUMBER_0_59>>
<<CRON_MINUTE_VALUE>>       := <<CRON_MINUTE_BASE>> | <<CRON_ANY_VALUE>>
<<CRON_MINUTE_RANGE>>       := <<CRON_MINUTE_BASE>> "-" <<CRON_MINUTE_BASE>>
<<CRON_MINUTE>>             := <<CRON_ANY_VALUE>>
                                | <<CRON_MINUTE_STEP>>
                                | <<CRON_MINUTE_LIST>>
                                | <<CRON_MINUTE_RANGE_LIST>>
<<CRON_MINUTE_STEP>>        := <<CRON_MINUTE_VALUE>> "/" <<NATURAL_NUMBER>>
<<CRON_MINUTE_LIST>>        := <<CRON_MINUTE_BASE>> "," <<CRON_MINUTE_LIST>>
                                | <<CRON_MINUTE_BASE>>
<<CRON_MINUTE_RANGE_LIST>>  := <<CRON_MINUTE_RANGE>> "," <<CRON_MINUTE_RANGE_LIST>>
                                | <<CRON_MINUTE_RANGE>>

<<CRON_HOUR_BASE>>          := <<CRON_NUMBER_0_23>>
<<CRON_HOUR_VALUE>>         := <<CRON_HOUR_BASE>> | <<CRON_ANY_VALUE>>
<<CRON_HOUR_RANGE>>         := <<CRON_HOUR_BASE>> "-" <<CRON_HOUR_BASE>>
<<CRON_HOUR>>               := <<CRON_ANY_VALUE>>
                                | <<CRON_HOUR_STEP>>
                                | <<CRON_HOUR_LIST>>
                                | <<CRON_HOUR_RANGE_LIST>>
<<CRON_HOUR_STEP>>          := <<CRON_HOUR_VALUE>> "/" <<NATURAL_NUMBER>>
<<CRON_HOUR_LIST>>          := <<CRON_HOUR_BASE>> "," <<CRON_HOUR_LIST>>
                                | <<CRON_HOUR_BASE>>
<<CRON_HOUR_RANGE_LIST>>    := <<CRON_HOUR_RANGE>> "," <<CRON_HOUR_RANGE_LIST>>
                                | <<CRON_HOUR_RANGE>>

<<CRON_MONTH_DAY_BASE>>     := <<CRON_NUMBER_1_31>>
<<CRON_MONTH_DAY_VALUE>>    := <<CRON_MONTH_DAY_BASE>> | <<CRON_ANY_VALUE>>
<<CRON_MONTH_DAY_RANGE>>    := <<CRON_MONTH_DAY_BASE>> "-" <<CRON_MONTH_DAY_BASE>>
<<CRON_MONTH_DAY>>          := <<CRON_ANY_VALUE>>
                                | <<CRON_MONTH_DAY_STEP>>
                                | <<CRON_MONTH_DAY_LIST>>
                                | <<CRON_MONTH_DAY_RANGE_LIST>>
<<CRON_MONTH_DAY_STEP>>     := <<CRON_MONTH_DAY_VALUE>> "/" <<NATURAL_NUMBER>>
<<CRON_MONTH_DAY_LIST>>     := <<CRON_MONTH_DAY_BASE>> "," <<CRON_MONTH_DAY_LIST>>
                                | <<CRON_MONTH_DAY_BASE>>
<<CRON_MONTH_DAY_LIST>>     := <<CRON_MONTH_DAY_RANGE>> "," <<CRON_MONTH_DAY_RANGE_LIST>>
                                | <<CRON_MONTH_DAY_RANGE>>

<<CRON_MONTH_BASE>>         := <<CRON_NUMBER_1_12>>
<<CRON_MONTH_VALUE>>        := <<CRON_MONTH_BASE>> | <<CRON_ANY_VALUE>>
<<CRON_MONTH_RANGE>>        := <<CRON_MONTH_BASE>> "-" <<CRON_MONTH_BASE>>
<<CRON_MONTH>>              := <<CRON_ANY_VALUE>>
                                | <<CRON_MONTH_STEP>>
                                | <<CRON_MONTH_LIST>>
                                | <<CRON_MONTH_RANGE_LIST>>
<<CRON_MONTH_STEP>>         := <<CRON_MONTH_VALUE>> "/" <<NATURAL_NUMBER>>
<<CRON_MONTH_LIST>>         := <<CRON_MONTH_BASE>> "," <<CRON_MONTH_LIST>>
                                | <<CRON_MONTH_BASE>>
<<CRON_MONTH_LIST>>         := <<CRON_MONTH_RANGE>> "," <<CRON_MONTH_RANGE_LIST>>
                                | <<CRON_MONTH_RANGE>>


<<CRON_WEEK_DAY_BASE>>      := <<CRON_NUMBER_0_7>> | <<CRON_NUMBER_DAYS>>
<<CRON_WEEK_DAY_VALUE>>     := <<CRON_WEEK_DAY_BASE>> | <<CRON_ANY_VALUE>>
<<CRON_WEEK_DAY_RANGE>>     := <<CRON_WEEK_DAY_BASE>> "-" <<CRON_WEEK_DAY_BASE>>
<<CRON_WEEK_DAY>>           := <<CRON_ANY_VALUE>>
                                | <<CRON_WEEK_DAY_STEP>>
                                | <<CRON_WEEK_DAY_LIST>>
                                | <<CRON_WEEK_DAY_RANGE_LIST>>
<<CRON_WEEK_DAY_STEP>>      := <<CRON_WEEK_DAY_VALUE>> "/" <<NATURAL_NUMBER>>
<<CRON_WEEK_DAY_LIST>>      := <<CRON_WEEK_DAY_BASE>> "," <<CRON_WEEK_DAY_LIST>>
                                | <<CRON_WEEK_DAY_BASE>>
<<CRON_WEEK_DAY_LIST>>      := <<CRON_WEEK_DAY_RANGE>> "," <<CRON_WEEK_DAY_RANGE_LIST>>
                                | <<CRON_WEEK_DAY_RANGE>>
```

### Fuzzy triggers

Examples:

```plaintext
every 3 hours
every Monday at 4 AM
every April on Mondays at 4 AM
...
```

- TODO: needs to still be supported.
