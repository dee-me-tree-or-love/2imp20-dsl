# Declaring Actions and Expressions in AIL

Example:

```plaintext
Actions : {
    notify : <%src, channels*> (
        channels @> {c | send_msg : {c, %src.metadata}}
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
   ...
),
```

### Top level action collection

```plaintext
<<ACTION_DECLARATIONS>>  := "Actions : {" {<<ACTION_CONFIG>> ","}* "}"
```

### Individual action config

> For `<<IDENTIFIER>>` see [basics.md](./basics.md).  
> For `<<VALUE>>` see [basics.md](./basics.md).  

```plaintext
<<ACTION_CONFIG>>               := <<ACTION_IDENTIFER>> : ("<" <<ACTION_PARAMETERS>> ">")? "(" <<ACTION_BODY>> ")"
<<ACTION_IDENTIFER>>            := <<IDENTIFIER>>
<<ACTION_PARAMETERS>>           := <<ACTION_BASIC_PARAMETERS>> | <<ACTION_SOURCE_PARAMETERS>>
<<ACTION_BASIC_PARAMETERS>>     := {<<ACTION_PARAMETER>> ","}*
<<ACTION_SOURCE_PARAMETERS>>    := <<ACTION_SOURCE_PARAMETER>> ("," {<<ACTION_PARAMETER>> ","}+)?
<<ACTION_PARAMETER>>            := <<IDENTIFIER>>
<<ACTION_SOURCE_PARAMETER>>     := "%src"
<<ACTION_BODY>>                 := {<<EXPRESSION_BODY>> ";"}+
```

### Action composition

_TODO: this needs to still be worked out._

## Expression syntax

Examples:

```plaintext
2;
size = 2.0 ml;
(size = 42);
age = 3 + 5.0;
size;
people = [ "Buzz", "Woody", "Mr. Potato Head" ];
people @> {c | c $> {a, char | a ++ char } };
channels @> {c | send_msg : {c, %src.metadata}};
* > 30;
```

### Expression body

> For `<<IDENTIFIER>>` see [basics.md](./basics.md).  
> For `<<PLANT_IDENTIFIER>>` see [plants](./plants.md).  
> For `<<ATTRIBUTE>>` see [basics.md](./basics.md).  

```plaintext
<<EXPRESSION_BODY>>         := {<<LINE_EXPRESSION>> ";"}*
<<LINE_EXPRESSION>>         := "(" <<CORE_EXPRESSION>> ")" | <<CORE_EXPRESSION>>
<<CORE_EXPRESSION>>         :=  <<UNIT_EXPRESSION>>
                                | <<STATEMENT_EXPRESSION>>
                                | <<IF_THEN_ELSE_EXPRESSION>>
                                | <<PL_THRESHOLD_EXPRESSION>>
<<UNIT_EXPRESSION>>         := <<IDENTIFIER>> | <<VALUE>> | <<ACTION_EXPRESSION>>
<<STATEMENT_EXPRESSION>>    := <<UNIT_EXPRESSION>> <<OPERATOR>> <<STATEMENT_EXPRESSION>>
                                | <<UNIT_EXPRESSION>>
<<IF_THEN_ELSE_EXPRESSION>> := "if" <<UNIT_EXPRESSION>>
                                "meets" <<PL_THRESHOLD_EXPRESSION>>
                                "then do" <<STATEMENT_EXPRESSION>>
                                "else do" <<STATEMENT_EXPRESSION>>
<<PL_THRESHOLD_EXPRESSION>> := "*" <<OPERATOR>> <<UNIT_EXPRESSION>>
```
