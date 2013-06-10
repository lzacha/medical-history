<%=packageName ? "package ${packageName}\n" : ''%>


class ${name = propertyName.replace('Instance','')}Service {
	
	def get(long id) {
		def  ${propertyName} = ${className}.get(id);
	}
	
	def save(${className} ${propertyName}) {
		${propertyName}.save();
	}
}