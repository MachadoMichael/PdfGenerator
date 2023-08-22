> ## PDF Generator
> This project offers an API to transform your text or HTML content into a PDF file.
>
> #### Integration
> To use the API, simply send the content of the body in the request. You don't need to include the `<body></body>` tags, just the content itself. The system will incorporate the content into a boilerplate.
>
> You can utilize CSS formatting as long as it's written within the respective tag. For instance: `<h1 style="color:blue;">Hello World!</h1>`.
>
> #### Development
> - Controllers: The PdfController manages the route ("/pdf"). Currently, it only includes a `get("/generate")` route, where we instantiate a PdfService, create a file, and place it in the headers of our response.
>
> - Entities: The Html class is responsible for constructing the document based on an HTML file. It contains a variable named `full` that combines the HTML boilerplate with the content of the body, which is passed as a parameter in the constructor.
>
> - Services: PdfService is responsible for generating the PDF file. To achieve this, I use the ITextRenderer (9.1.22) library. I instantiate the ITextRenderer in a variable called `renderer`, and using the `setDocumentFromString` method, I insert `html.getFull()`. Then, I define the layout and generate the file.
>
> ### Project Tools
> - Java 17
> - Spring Boot 3
>
> In the pom file, I've added the following dependencies:
> ```xml
> <dependencies>
> 	<dependency>
> 		<groupId>org.springframework.boot</groupId>
> 		<artifactId>spring-boot-starter-web</artifactId>
> 	</dependency>
> 
> 	<dependency>
> 		<groupId>org.xhtmlrenderer</groupId>
> 		<artifactId>flying-saucer-pdf</artifactId>
> 		<version>9.1.22</version> <!-- Use the latest version -->
> 	</dependency>
> </dependencies>
> ```
