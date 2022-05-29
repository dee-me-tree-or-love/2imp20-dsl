computer my_computer {
	storage my_storage {
		storage: SSD of 1024 GiB
	},
	|-
	   This is just a fancy comment.
	-|
	
	-- error: total storage size is greater than 8192 GB
	storage my_storage1 {
		storage: HDD of 1024 GiB,
		storage: SSD of 1024 GiB
	},
	storage my_storage2 {
		storage: HDD of 1024 GiB,
		storage: SSD of 1024 GiB,
		storage: HDD of 1024 GiB
	},
	storage my_storage3 {
		storage: HDD of 1024 GiB,
		storage: SSD of 1024 GiB,
		storage: HDD of 1024 GiB,
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