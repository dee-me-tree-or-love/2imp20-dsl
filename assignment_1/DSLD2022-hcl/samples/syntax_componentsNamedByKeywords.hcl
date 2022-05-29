-- a computer with label named by keywords: 'MiB' 
computer MiB {
	storage storage {
		storage: SSD of 512 GiB
	},
	|-
	   This is just a fancy comment.
	-|
	display mdisplay {
	   diagonal: 30 inch,
	   type: 5K
	},
	-- this is a reuse
	storage,
    -- this is a configuration component again
	processing mprocessing {
	   cores: 4,
	   speed: 2 Ghz,
	   L1: 64 KiB,
	   L2: 4 MiB,
	   L3: 15 MiB
	},
	mprocessing,
	mdisplay
}