dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    username = "dbuser"
    password = "changeme"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://127.0.0.1/wherecaniget-dev"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://127.0.0.1/wherecaniget-test"
        }
    }
    production {
        dataSource {
            //dbCreate = "update"
            url = "jdbc:postgresql://127.0.0.1/wherecaniget"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
