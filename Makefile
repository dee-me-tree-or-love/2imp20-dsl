# `make assignment_1.zip` builds a submission for assignment 1
assignment_1.zip:
	zip -r assignment_1.zip assignment_1/

# `make assignment_2.zip` builds a submission for assignment 2
assignment_2.zip:
	zip -r assignment_2.zip assignment_2/

# `make clear_zips` removes all the assignment zip files
.PHONY: clear_zips
clear_zips:
	rm -rf assignment*.zip