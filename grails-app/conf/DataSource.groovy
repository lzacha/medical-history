dataSource {
    pooled = true

    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
    
    
    /*
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
    */
}

/*
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'com.googlecode.hibernate.memcached.MemcachedCacheProvider'

    memcached {
        servers = "127.0.0.1:11211 127.0.0.1:11311 127.0.0.1:11411 127.0.0.1:11511 127.0.0.1:11611"
    }
}
*/

hibernate {
    //cache.use_second_level_cache = true
    //cache.use_query_cache = false
    //cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}


// environment specific settings
environments {
    development {

        /*
        dataSource {
            dbCreate = "create" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/medicalhistory"
            username = "medicalhistory"
            password = "medicalhistory"

        }
        */
    

        /* --> To see
        hibernate {
            show_sql = true
        }
        <-- */


        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE"
        }

    }
    test {
        /*
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE"
        }*/
    }
    production {
        /*
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE"
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
        } */
    }
}
