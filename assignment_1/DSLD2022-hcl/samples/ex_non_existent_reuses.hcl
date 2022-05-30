computer my_computer {
    storage my_storage {
        storage: SSD of 512 GiB
    },
    |-
       The reuse below is invalid because
       1. `my_display` and `my_storage` are not declared
    -|
    -- this is an ok reuse
    my_storage,
    -- these are failing reuses
    my_display,
    my_storage2
}