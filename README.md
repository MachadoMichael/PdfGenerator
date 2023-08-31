> ## PDF Generator
> This project offers an API to convert your text or HTML content into a PDF file.
>
> #### Integration
> This API provides a straightforward solution for generating PDF files, primarily designed to create reports for other services within the context of my ongoing development projects.
>
> #### Development
> - Controllers: The `PdfController` manages the route ("/pdf"). It includes a `get("/generate")` route, which triggers the PDF generation process. It instantiates a new `Pdf` by passing the `documentData` and adds the generated PDF to the response headers.
>
> - Entities: The `Pdf` class is used to create the PDF content. It consists of three private variables: `pdfOutputStream`, `renderer`, and `htmlContent`. The constructor initializes the PDF content by encapsulating the provided `documentData` within a basic HTML structure. The structure includes standard HTML elements such as `<html>`, `<head>`, and `<body>`, and integrates the `documentData` within the body section of the HTML. This results in the creation of a complete HTML document, which, when processed by the renderer, generates the final PDF file containing the desired content.
>
> - Services: The `PdfService` now only has a `generateFile` method, which receives a `Pdf` parameter. Inside the method, the renderer is configured to generate the PDF from the HTML content.
>
> ### Project Tools
> - Java 17
> - Spring Boot 3
>
> The following dependencies are added to the pom file:
> ```xml
> <dependencies>
>     <dependency>
>         <groupId>org.springframework.boot</groupId>
>         <artifactId>spring-boot-starter-web</artifactId>
>     </dependency>
> 
>     <dependency>
>         <groupId>org.xhtmlrenderer</groupId>
>         <artifactId>flying-saucer-pdf</artifactId>
>         <version>9.1.22</version> <!-- Use the latest version -->
>     </dependency>
> </dependencies>
> ```
