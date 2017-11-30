# The Props Source File

Prop source files specify a prop's data and behavior.

They are found in the Props config directory at `/config/props/source/headers/` and written in the HOCON file format.

## Tags

Currently, the following tags are available:

| Tag       | Explanation                                                                          | Possible values	    |
| --------- | ------------------------------------------------------------------------------------ | :--------------------: |
| prop_id   | The prop's id as it is registered in the system                                      | N/A		  			|
| prop_name | The prop's name as seen by the user                                  				   | N/A					|
| prop_type	| Specifies how a prop will be treated												   | block; item;			|
