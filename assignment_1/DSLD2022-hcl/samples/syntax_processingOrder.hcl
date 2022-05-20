computer my_computer {
	storage my_storage {
		storage: SSD of 512 GiB
	},
	processing my_CPU {
		cores: 4,
		speed: 2 Ghz,
		L1: 64 KiB,
		L2: 4 MiB,
		L3: 15 MiB
	},
	processing m_CPU {
		cores: 5,
		speed: 2 Ghz,
		L2: 4 MiB,
		L1: 64 KiB,
		L3: 15 MiB
	},
	display my_display {
		diagonal: 30 inch,
		type: 5K
	},
	my_display,
	my_storage
}