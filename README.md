BukkitPopulators
================

A collection of BlockPopulators for use with Bukkit

Dependencies
------------

If the [SkylandsPlus](http://dev.bukkit.org/bukkit-plugins/skylandsplus/)
plugin is installed, its Populators will be automatically available through
BukkitPopulators as well.

Usage
------------
It's suggested you use Maven to use this library.
Add the following to your pom.xml:

```
<repositories>
  <repository>
    <id>bukkitpopulators-repo</id>
    <url>https://raw.github.com/Lucariatias/BukkitPopulators/mvn-repo/</url>
  </repository>
</repositories>
<dependencies>
  <dependency>
    <groupId>org.bukkit</groupId>
    <artifactId>bukkit</artifactId>
    <version>1.6.2-R1.0</version>
  </dependency>
</dependencies>
```

This will allow you to use any of the populators.
Just make sure to have any users of your plugin install this.

Compilation
------------
First, make sure to have Git and Maven installed.
Clone the repository and use Maven to compile it:

```
git checkout https://github.com/Lucariatias/BukkitPopulators.git
mvn clean install
```

If you want to deploy Maven artifacts, make sure you add the following to your Maven settings.xml (located in your .m2 folder):

```
<settings>
  <servers>
    <server>
      <id>github</id>
      <username>YOUR-USERNAME</username>
      <password>YOUR-PASSWORD</password>
    </server>
  </servers>
</settings>
```

Also, make sure to use chmod 700 settings.xml so it's not world-readable.
For the most part though, I (Lucariatias) should handle frequently updating the maven repo.