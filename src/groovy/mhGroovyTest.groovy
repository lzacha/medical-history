/*
def number = 0

new File ('/Users/lzacharewicz/export_pedro.xml').eachLine { line ->
	number++
	println "$number: $line"
}
*/

/*
def classes = [String, List, File]
for (clazz in classes) {
	println clazz.'package'.name //name
}
*/

//println( [String, List, File, ThreadLocal].'package'.name )

/*
def number = 0
new File ('/Users/lzacharewicz/Documents/Personal/Practica Profesional/Development/medical-history/src/').eachFileRecurse { println it }
*/

def current = 1
def next = 1
60.times {
	print current + ' '
	newCurrent = next
	next = next + current
	current = newCurrent
}
println ''