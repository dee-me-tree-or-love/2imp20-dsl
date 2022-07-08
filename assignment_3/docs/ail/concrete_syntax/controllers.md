# Declaring execution controllers in AIL

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
