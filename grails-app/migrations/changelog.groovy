databaseChangeLog = {

	changeSet(author: "rguerra (generated)", id: "1335567361948-1") {
		createTable(tableName: "persistent_logins") {
			column(name: "series", type: "varchar(64)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "persistent_loPK")
			}

			column(name: "last_used", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "varchar(64)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(64)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rguerra (generated)", id: "1335567361948-2") {
		createTable(tableName: "sec_profile") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "sec_profilePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}
		}
	}

	changeSet(author: "rguerra (generated)", id: "1335567361948-3") {
		createTable(tableName: "sec_user") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "sec_userPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}
		}
	}

	changeSet(author: "rguerra (generated)", id: "1335567361948-4") {
		createTable(tableName: "sec_user_sec_profile") {
			column(name: "sec_profile_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "sec_user_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rguerra (generated)", id: "1335567361948-5") {
		addPrimaryKey(columnNames: "sec_profile_id, sec_user_id", constraintName: "sec_user_sec_PK", tableName: "sec_user_sec_profile")
	}

	changeSet(author: "rguerra (generated)", id: "1335567361948-6") {
		createIndex(indexName: "authority_unique_1335567361933", tableName: "sec_profile", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "rguerra (generated)", id: "1335567361948-7") {
		createIndex(indexName: "username_unique_1335567361940", tableName: "sec_user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "rguerra (generated)", id: "1335567361948-8") {
		addForeignKeyConstraint(baseColumnNames: "sec_profile_id", baseTableName: "sec_user_sec_profile", constraintName: "FKDCABAF75D77794E5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sec_profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "rguerra (generated)", id: "1335567361948-9") {
		addForeignKeyConstraint(baseColumnNames: "sec_user_id", baseTableName: "sec_user_sec_profile", constraintName: "FKDCABAF757553F5EF", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sec_user", referencesUniqueColumn: "false")
	}

	changeSet(author: "rguerra (generated)", id: "1335567361948-10") {
		createSequence(sequenceName: "hibernate_sequence")
	}
}
