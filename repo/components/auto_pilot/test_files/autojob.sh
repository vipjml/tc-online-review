export CLASSPATH=dist/base_exception.jar:dist/configuration_manager.jar:dist/command_line_utility.jar:dist/object_factory.jar:dist/logging_wrapper.jar:dist/database_abstraction.jar:dist/db_connection_factory.jar:dist/workdays.jar:dist/search_builder.jar:dist/id_generator.jar:dist/typesafe_enum.jar:dist/executable_wrapper.jar:dist/job_scheduling.jar:dist/xerces.jar:build/classes:build/testClasses:conf:test_files

java com.topcoder.management.phase.autopilot.AutoPilotJob $*
