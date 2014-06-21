JCR-Explorer
============

Explore Jackrabbit Repository, Search, Query and Manage your JCR Repo Visually

### Content Display and Navigation
![JCR Explorer Content Display](https://github.com/mehmoodz/jcr-explorer/raw/master/1.png)

### Query Management
![JCR Explorer Query Manager](https://github.com/mehmoodz/jcr-explorer/raw/master/2.png)


## Features

* Read Only Tree-based JCR content exploration
	- [X] JCR Repo Manager Setup
	- [X] Unit Tests for JCR exploration
	- [X] Query Manager
	- [X] Content Explorer Service
	- [X] Mockup Tests
	- [X] UI for Tree based exploration
	- [X] Node Details
* Query Browser with XPATH , JCR-SQL2 Support
    - [X] Support for JCR-SQL, JCR-SQL2, XPATH support 
* Dependency Graph for the contents published
    - [X] Planned just full-text for now (for e.g.,) SELECT parent.*  FROM [nt:base] AS parent  where CONTAINS(parent.*, 'BlackJack')
		
* Configurable inside existing Projects (Maven overlay, or WEBDAV Connections)
	- [X] JNDI Integration
	- [X] Spring Data Source
	- [ ] WEBDAV

## Getting Started

### Integrating JCR Explorer through JNDI 
	
* Define org.springmodules.jcr.jackrabbit.RepositoryFactoryBean for Repository object
	
	- "jackrabbit.repository.path" JNDI Name needs to be specified in server.xml like
	
	<Resource name="jackrabbit.repository.path" auth="Container" type="javax.jcr.Repository" factory="org.apache.jackrabbit.core.jndi.BindableRepositoryFactory" 
		configFilePath="<CONFIG_DIR>/jcrconfig.xml" repHomeDir="<JCR-HOME-DIR>" />
		
* Inject repository object in JCRManager configuration defined in jcr-context-core.xml in JCRExplorerCore Module
	
	- Have a look at the jcrexplorer-web-servlet.xml to integrate define JNDI lookup configuration
	
* Copy web resources to your web app project
	- Under JCRExplorerWeb/src/main/webapp/
	
* Make sure your web.xml has necessary DispatcherServlet Configuration as found JCRExplorerWeb/src/main/webapp/WEB-INF/web.xml

### Thanks To:
 - [SB Admin 2 Theme](http://startbootstrap.com/sb-admin-v2)
 - [JQTree](http://mbraak.github.io/)
 - [VKBeatuify2.0](http://code.google.com/p/vkbeautify/)
 
