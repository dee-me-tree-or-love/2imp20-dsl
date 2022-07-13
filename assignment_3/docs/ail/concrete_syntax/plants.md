# Declaring Plants in AIL

Example:

```plaintext
Plants : {
    Strawberry <<
        water_use : 5 mm,
        min_temp  : 20 C,
        max_water : 100 mm,
    >>
}
```

## Concrete syntax

### Top level plant collection

```f#
<<PLANT_DECLARATIONS>>  := "Plants : {" {<<PLANT_CONFIG>> ","}* "}"
```

### Individual plant config

> For `<<IDENTIFIER>>` see [basics.md](./basics.md).  
> For `<<ATTRIBUTE>>` see [basics.md](./basics.md).  

```f#
<<PLANT_CONFIG>>        := <<PLANT_IDENTIFIER>> "<<" <<PLANT_ATTRIBUTES>> ">>"
<<PLANT_IDENTIFIER>>    := <<IDENTIFIER>>
<<PLANT_ATTRIBUTES>>    := {<<ATTRIBUTE>> ","}*
```
