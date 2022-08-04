# Why

This is intended to be a POC that show how we can leverage a tool like Open-rewrite to update our
codebase running on old JDKs to new ones. The target is to start from java11 and see how we can push it to java17

## Start
- [x] Create a naive spring boot app running on Java11
- [ ] Start with the open re-write tool and apply the default implementation to update it a little
- [ ] See how you can add your own rule and how open re-write can use that to update the code base
- [ ] Maybe introduce other tools which traverses over an AST and produces something entirely different
  - [ ] ErrorProne
  - [ ] ErrorChecker
  - [ ] Antlr
  - ...

## POC Flow and Code Organisation
- [ ] v1_0: Plan here is to write a naive code base and see what open re-write does to it.
  - Packages
    - Services - Business logic as interfaces will be here, together with an implementation package
    - Controllers - Classes that exposes REST endpoint in the spring way
    - Models - Data Structures describing the business domains and data access objects
    - Configs - Spring managed classes

- [ ] v2_0: Plan here is to write a code base with a data access layer or connection to a DB
  - Packages: v_1 +
    - Entities - Data Structures describing the business domains, and a reflection of the DB
    - Repositories - Jpa Interfaces that allows communication with the DB