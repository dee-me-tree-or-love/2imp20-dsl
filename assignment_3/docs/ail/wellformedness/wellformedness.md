# Wellformedness for AIL 

### General wellformedness
- The label for each module, action, plant, asset and ovserver must be unique.
-Every module must have at least one action and one asset. 

### Plants wellformedness
- Parameter labels of `Plants` must be unique;
- `Plants` template should not have same configurations.
- `Plants` template should not be empty.


### Asset wellformedness
- The `AIL` assets contain two types : *Plantation* and *WaterSource*, which need to be specified in asset statement.
- Each *Plantation* asset must contain a plant *template*, the template can be predefined in `Plants` or defined in asset statement. <!--or must have a template? -->


### Action wellformedness
- `Actions` must contain one or more parameters except for *%src*.
- Variables in actions must be stated before using.

### Observer wellformedness
- Every `Observer` should have one unique legal mailing address. 
