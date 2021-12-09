
Add this in your root build.gradle file (not your module build.gradle file):

allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}

Add this to your module's build.gradle file (make sure the version matches the JitPack badge above):

dependencies {
	...
	implementation :com.github.praveen2021aikaki/AuthO:1.0.1
}
