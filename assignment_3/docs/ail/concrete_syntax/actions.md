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
    check_avg_temp : <%src, condition, job> (
        size = %src.items $> {a, _ | a + 1};
        total = %src.items $> {a, i | a + i.temp};
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

```f#
<<ACTION_DECLARATIONS>>  := "Actions : {" {<<ACTION_CONFIG>> ","}* "}"
```

### Individual action config

> For `<<IDENTIFIER>>` see [basics.md](./basics.md).  
> For `<<VALUE>>` see [basics.md](./basics.md).  

```f#
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
people @> {c | c #> {char | char != "o"} $> {a, char | a ++ char} };
channels #> {c | c ~~ "abbie"} @> {c | send_msg : {c, %src.metadata}};
* > 30;
total_age = my_plant.age + 30;
```

### Expression body

> For `<<IDENTIFIER>>` see [basics.md](./basics.md).  
> For `<<ATTRIBUTE_ACCESS>>` see [basics.md](./basics.md).  

```f#
<<EXPRESSION_BODY>>             := {<<LINE_EXPRESSION>> ";"}*
<<LINE_EXPRESSION>>             := "(" <<CORE_EXPRESSION>> ")" | <<CORE_EXPRESSION>>
<<CORE_EXPRESSION>>             := <<STATEMENT_EXPRESSION>>
                                    | <<IF_THEN_ELSE_EXPRESSION>>
                                    | <<TMPL_STATEMENT_EXPRESSION>>
                                    | <<UNIT_EXPRESSION>>
<<STATEMENT_EXPRESSION>>        := <<UNIT_EXPRESSION>> <<OPERATOR>> <<STATEMENT_EXPRESSION>>
                                    | <<UNIT_EXPRESSION>>
<<UNIT_EXPRESSION>>             := "(" <<CORE_UNIT_EXPRESSION>> ")" | <<CORE_UNIT_EXPRESSION>>
<<CORE_UNIT_EXPRESSION>>        := <<IDENTIFIER>>
                                    | <<ATTRIBUTE_ACCESS>>
                                    | <<VALUE>>
                                    | <<ACTION_EXPRESSION>>
                                    | <<MAPPER_EXPRESSION>>
<<IF_THEN_ELSE_EXPRESSION>>     := "if" <<UNIT_EXPRESSION>>
                                    "meets" <<TMPL_STATEMENT_EXPRESSION>>
                                    "then do" <<STATEMENT_EXPRESSION>>
                                    "else do" <<STATEMENT_EXPRESSION>>
<<TMPL_STATEMENT_EXPRESSION>>   := "*" <<OPERATOR>> <<UNIT_EXPRESSION>>
<<ACTION_EXPRESSION>>           := <<ACTION_IDENTIFIER>> ": {" {<<STATEMENT_EXPRESSION>> ","}* "}"
<<MAPPER_EXPRESSION>>           := <<UNIT_EXPRESSION>> <<MAPPER>> <<MAPPER_CLAUSE>>
<<MAPPER_CLAUSE>>               := "{" {<<IDENTIFIER>> ","}* "|" <<STATEMENT_EXPRESSION>> "}"
<<OPERATOR>>                    := "=" | "+" | "-" | "*" | "/" | "%" | "^" | "++" | "==" | "!=" | "~~" | "and" | "or"
<<MAPPER>>                      := "@>" | "#>" | "$>"
```
