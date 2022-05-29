computer my_computer {
	storage my_storage {
		storage: SSD of 512 GiB
	},
	|-
	   The two components below do no pass checkWellformedness
	   1. my_display label is duplicate
	-|
	-- first use of my_display
	display my_display {
	   diagonal: 30 inch,
	   type: 5K
	},
    -- first use of my_display
    display my_display {
       diagonal: 32 inch,
       type: 4K
    },
	-- this is a reuse
	my_storage
}