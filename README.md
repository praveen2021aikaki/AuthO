
Add this in your root build.gradle file (not your module build.gradle file):

allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
