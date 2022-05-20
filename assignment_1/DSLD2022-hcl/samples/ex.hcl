computer my_computer {
	storage my_storage {
		storage: SSD of 512 GiB
	},
	processing my_CPU {
		cores: 4,
		speed: 2 Ghz,
		L1: 64 Kib,
		L2: 4 Mib,
		L3: 15 Mib
	},
	display my_display {
		diagonal: 30 inch,
		type: 5K
	},
	my_display,
	my_storage
}