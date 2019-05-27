# (Di|Con)vergent Mob Refactoring

Please refer to [https://github.com/procurios/diconvergent](https://github.com/procurios/diconvergent) for information and how-to concerning the workshop.

## Installation
Please clone this project and run the tests. If you have any issues, do not hesitate to contact us.

* Using Gradle:
    - Open a terminal and go to the folder of your git clone
    - gradle test

## Install Gradle

It’s highly recommended to use an installer:

* [SDKMAN](http://sdkman.io/)
* [Homebrew](https://brew.sh/) (brew install gradle)

As a last resort, if neither of these tools suit your needs, you can download the binaries from 
http://www.gradle.org/downloads. Only the binaries are required, so look for the link to gradle-version-bin.zip. 
(You can also choose gradle-version-all.zip to get the sources and documentation as well as the binaries.)

Unzip the file to your computer, and add the bin folder to your path.

To test the Gradle installation, run Gradle from the command-line:

`gradle`

If all goes well, you see a welcome message:

````
:help

Welcome to Gradle 2.3.

To run a build, run gradle <task> ...

To see a list of available tasks, run gradle tasks

To see a list of command-line options, run gradle --help

BUILD SUCCESSFUL

Total time: 2.675 secs
````
You now have Gradle installed.