class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        //Don't like /searchable
        "/search"(controller: "searchable")

        //Don't like /searchable
        "/suggest"(controller: "medicalHistory", action: "suggest")

        "/"(view:"/index")
		"500"(view:'/error')
	}
}
