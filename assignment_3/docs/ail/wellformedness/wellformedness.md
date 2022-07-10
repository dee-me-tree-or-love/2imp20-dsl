# Wellformedness for AIL

## Intended welformedness checks

### General wellformedness

- [x] The label for each module, action, plant, asset and ovserver must be unique. 
- [x] Every program must have at least one action and one asset.

### Plants wellformedness
- [x] Parameter labels of `Plants` must be unique.
- [ ] `Plants` template should not be empty.
- [ ] `Plants` template should have different configurations.

### Asset wellformedness

- [ ] The `AIL` assets contain two types : *Plantation* and *WaterSource*, which need to be specified in asset statement.
- [ ] Each *Plantation* asset must contain a plant *template*, the template can be predefined in `Plants` or defined in asset statement. <!--or must have a template? -->

### Action wellformedness

- [x] Variables in actions must be stated before using.
- [ ] Scheduling date configuration must follow the date specification(eg: "daily 9 am"). 

### Observer wellformedness

- [x] Every `Observer` should have one unique mailing address.
- [ ] The mailing address of `Observer` must be legal.

