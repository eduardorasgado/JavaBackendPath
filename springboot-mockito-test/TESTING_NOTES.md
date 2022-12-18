# Testing Notes

For executing all tests on the project, first we need to be sure that we have only a single integration test class <br/>
because at the moment we run an integration test class a server is created and next integration test class will run <br/>
with errors due to data has been affected by the last integration test executed. <br/>

If we have multiple integration test classes on our project we can use tags above these classes and run different <br/>
configurations for every class, to accomplish this purpose, in our Build and run menu we need to add the excluded tag <br/>
using a ! symbol as prefix, as follows: <br/>

<pre><code>
!REST_TEMPLATE_INTEGRATION_TEST
</code></pre>
This will execute every single test class on out project but the one tagged as REST_TEMPLATE_INTEGRATION_TEST.

We can also accomplish this using the embedded maven file on our project. We can type directly in our console: <br/>

<pre><code>
.\mvnw test -Dgroups="!REST_TEMPLATE_INTEGRATION_TEST"
</code></pre>
