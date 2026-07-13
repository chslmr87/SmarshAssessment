##

Exercise - Cache implementation

##### Task description

Write a java program that fetch url content (source) from web and save it locally as a file.  
The program should fetch each url from web only once.  
If the page is already fetched (relevant file exists locally) the content will be retrieved from file (not from web).

##### Each time you run the program the scenario should be as follows

- Get url value (use it as a java member)
- Check if this url content already exists locally
  - if not exist:
    - get relevant page content from web
    - save content to file
    - print the original date (when the page content has been fetched from web).
    - print the URL
    - print the page content
  - if exist (file already been fetched):
    - print the original date (when the page content has been fetched from web).
    - print the URL
    - print the page content
- The app should be shut down.

##### Requirements

- Use java 8 or any late version
- Use Maven (or Gradle) to compile you code
- Write UNIT Test in the right places
- Add relevant prints (for troubleshooting)
- **Write your relevant assumptions (if exist)**
