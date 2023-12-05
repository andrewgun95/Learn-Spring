class HelloWorld {
		
		// HelloWorld can run in every location use something called classpath
		// Classpath : a parameter in Java Virtual Machine that specify the location of userdefined classes and packages

		// Step :
		// (1) Compile java file into class file
		//     * In this directory :
		//     * javac HelloWorld.java
		// (2) Store classpath in this directory on JVM 
		//     * set CLASSPATH="D:/Penting/Learn Spring/Practice"
		// (3) Run your java byte code anywhere you want 
		//     * java HelloWorld
		// alternative (absolute ?):
		// (2) Run your java byte code with specify a classpath
		//     * java -classpath "D:/Penting/Learn Spring/Practice" HelloWorld
		
		public static void main(String[] args){
				System.out.println("Hello, World!");
		}
		
		// Relative Path
		// can run java file byte code only this directory
		// dir = "D:/Penting/Learn Spring/Practice"
		//			(+) HelloWorld.class
		//			(+) HelloWorld.java
		// * java HelloWorld
		
		// Class Path
		// can run java file byte code on every where location
		// dir = "C:/User/Andreas"
		// * java HelloWorld
		
}
