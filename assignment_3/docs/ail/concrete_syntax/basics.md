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

```f#
<<NIL>>             := "{}"
<<UNIT>>            := ("\\"(\w)+(("^")<<NATURAL_NUMBER>>)? | <<NIL>>)
<<BOOLEAN_TRUE>>    := "True"
<<BOOLEAN_FALSE>>   := "False"
<<BOOLEAN>>         := <<BOOLEAN_FALSE>> | <<BOOLEAN_TRUE>>
<<NATURAL_NUMBER>>  := [0-9]+
<<REAL_NUMBER>>     := (-)?<<NATURAL_NUMBER>>+("."<<NATURAL_NUMBER>>+)?
<<UNIT_NUMBER>>     := <<REAL_NUMBER>> <<UNIT>>
<<STRING>>          := "\"" .* "\""
<<COLLECTION>>      := "[" (<<VALUE>>)* "]"
<<VALUE>>           := <<NIL>> | <<BOOLEAN>> | <<REAL_NUMBER>> | <<STRING>> | <<UNIT_NUMBER>> | <<COLLECTION>>
```

#### Remarks on values

- `<<UNIT>>`, `<<BOOLEAN_TRUE>>`, `<<BOOLEAN_FALSE>>` can not be used outside of their respective containers.

## Identifiers and Attributes

Examples:

```plaintext
Strawberry
my_plant : Strawberry
my_water_level : 35 \ml
other_water_level : my_water_level
my_plant.my_water_level
```

### Identifier and Attribute syntax

> For `<<VALUE>>`, see [values](#values).  

```f#
<<IDENTIFIER>>          := (\w)(\w|"-"|"_")+
<<ATTRIBUTE>>           := <<IDENTIFIER>> ":" (<<VALUE>> | <<IDENTIFIER>>)
<<ATTRIBUTE_ACCESS>>    := <<IDENTIFIER>> "." <<ATTRIBUTE_ACCESS>>
                            | <<IDENTIFIER>> "." <<IDENTIFIER>>
```
