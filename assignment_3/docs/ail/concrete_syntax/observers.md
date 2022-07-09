# Declaring Observers in AIL

Example:

```plaintext
Observers : {
    support <<support@farm.cool>>, 
    admin <<admin@farm.cool>>, 
    rss <<farm.feed.rss>>,
    abie <<abie@service.farm.cool>>
}
```

## Concrete syntax

### Top level observer collection

```f#
<<OBSERVER_DECLARATIONS>>   := "Observers : {"
                                    {<<OBSERVER_CONFIG>> ","}* 
                                "}"
```

### Individual plant config

> For `<<IDENTIFIER>>` see [basics.md](./basics.md).  
> For `<<STRING>>` see [basics.md](./basics.md).  

```f#
<<OBSERVER_CONFIG>>     := <<OBSERVER_IDENTIFIER>> "<<"
                                <<OBSERVER_BODY>>
                            ">>"
<<OBSERVER_IDENTIFIER>> := <<IDENTIFIER>>
<<OBSERVER_BODY>>       := <<STRING>>
```
