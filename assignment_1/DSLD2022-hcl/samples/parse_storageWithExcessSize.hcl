computer my_computer {
	-- error: single storage size is smaller than 32 GB
	storage my_storage {
		storage: SSD of 31 GiB
	},
	|-
	   This is just a fancy comment.
	-|
	
	-- error: single storage size is greater than 1024 GB
	storage my_storage1 {
		storage: HDD of 1028 GiB,
		storage: SSD of 1024 GiB
	},
	
	display my_display {
	   diagonal: 30 inch,
	   type: 5K
	},
	-- this is a reuse
	my_storage,
    -- this is a configuration component again
	processing my_processing {
	   cores: 4,
	   speed: 2 Ghz,
	   L1: 64 KiB,
	   L2: 4 MiB,
	   L3: 15 MiB
	},
	my_processing,
	my_display
}