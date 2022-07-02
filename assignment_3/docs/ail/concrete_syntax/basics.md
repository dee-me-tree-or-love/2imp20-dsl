# Concrete syntax for basic AIL concepts

## Comments

Examples:

```plaintext
// This is a single string comment
```

### Comment syntax

```plaintext
<<ONE_LINE_COMMENT>> := "// " .* 
```

#### Remarks on comments

- We do not support multiline comments in this iteration.

## Values

Examples:

```plaintext
9
"raspberry"
9 ml
True
[2, 3, 4 ml, 5, 6, 7, "eggs", ["spam", 2]]
```

### Value syntax

```plaintext
<<NIL>>             := "{}"
<<UNIT>>            := ([w/] | <<NIL>>)
<<BOOLEAN_TRUE>>    := "True"
<<BOOLEAN_FALSE>>   := "False"
<<BOOLEAN>>         := <<BOOLEAN_FALSE>> | <<BOOLEAN_TRUE>>
<<NUMBER>>          := (-)?[0-9]+("."[0-9]+)?
<<UNIT_NUMBER>>     := <<NUMBER>> <<UNIT>>
<<STRING>>          := "\"" .* "\""
<<COLLECTION>>      := "[" (<<VALUE>>)* "]"
<<VALUE>>           := <<NIL>> | <<BOOLEAN>> | <<NUMBER>> | <<STRING>> | <<UNIT_NUMBER>> | <<COLLECTION>>
```

#### Remarks on values

- `<<UNIT>>`, `<<BOOLEAN_TRUE>>`, `<<BOOLEAN_FALSE>>` can not be used outside of their respective containers.

## Identifiers and Attributes

Examples:

```plaintext
Strawberry
my_plant : Strawberry
my_water_level : 35 ml
other_water_level : my_water_level
```

### Identifier and Attribute syntax

> For `<<VALUE>>`, see [values](#values).  

```plaintext
<<IDENTIFIER>>  := [w/]
<<IDENTIFIER>>  := [w/]
<<ATTRIBUTE>>   := <<IDENTIFIER>> ":" (<<VALUE>> | <<IDENTIFIER>>)
```
