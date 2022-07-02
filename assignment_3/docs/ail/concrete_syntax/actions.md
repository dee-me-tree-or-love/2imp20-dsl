# Declaring Actions and Expressions in AIL

Example:

```plaintext
Actions : {
    notify : <%src, channels*> (
        channels @> {c, send_msg : {c, %src.metadata}}
    ),
    check_water : <%src, condition, job, fail_job> (
        if %src.water meets condition then do job else do fail_job
    ),
    check_avg_temp : <%src, condition(> 30 mm), job> (
        size = %src.items $> {_ | + 1};
        total = %src.items $> {i | + i.temp};
        if total/size meets condition then do job;
    ),
    send_report : <%src, channels*, name_match> (
        channels  #> {c | c ~~ "abie"}} @> {c, send_msg : {c, %src.metadata}}
    )
}
```

## Action concrete syntax

Example:

```plaintext
notify : <%src, channels*> (
    channels @> {c, send_msg : {c, %src.metadata}}
),
```

### Top level action collection

```plaintext
<<ACTION_DECLARATIONS>>  := "Actions : {" {<<ACTION_CONFIG>> ","}* "}"
```

### Individual action config

> For `<<IDENTIFIER>>` see [basics.md](./basics.md).  
> For `<<PLANT_IDENTIFIER>>` see [plants](./plants.md).  
> For `<<ATTRIBUTE>>` see [basics.md](./basics.md).  

```plaintext
<<ACTION_CONFIG>>           := <<ACTION_IDENTIFER>> : ("<" <<ACTION_ARGUMENTS>> ">")? "(" <<ACTION_BODY>> ")"
<<ACTION_IDENTIFER>>        := <<IDENTIFIER>>
<<ACTION_ARGUMENTS>>        := <<ACTION_BASIC_ARGUMENTS>> | <<ACTION_SOURCE_ARUGMENTS>>
<<ACTION_BASIC_ARGUMENTS>>  := {<<ACTION_ARGUMENT>> ","}*
<<ACTION_SOURCE_ARUGMENTS>> := <<ACTION_SOURCE_ARGUMENT>> ("," {<<ACTION_ARGUMENT>> ","}+)?
<<ACTION_ARGUMENT>>         := <<IDENTIFIER>>
<<ACTION_BODY>>             := {<<EXPRESSION>> ";"}+
```

## Expression syntax

Examples:

```plaintext

```