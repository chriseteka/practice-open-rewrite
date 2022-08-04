# Observations

- We can make our own library and include all the auto configs/setup based on the style we want, the formats we want and the rules we want to apply when re-writing
- You can add a simple `.YML` file to the root of your project, where you can define some rules you would like to apply, these are simple/naive rules and have nothing to do with traversals, because it is high-level and open rewrite has already implemented it
- There are different re-write packages, which is good, and you can choose which to include into your project. Or you can use to develop your own library/configuration that teams can share

# Challenges
- Not everyone agrees on same style and may not like when their codes are re-written. Enforcing adoption might be a challenge (We could make this optional)
- The file must be `rewrite.yml` (`rewrite.yaml` will fail), and any rule define must be activated in the pom, all rules including these customs you're allowed to specify comes disabled by default
- There are different pieces with varying versions which may introduce conflicts during upgrade and managing all of them could be tough for just an individual or in a big project