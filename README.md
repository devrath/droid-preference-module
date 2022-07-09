# droid-preference-module
![Banner](https://github.com/devrath/devrath/blob/master/images/Banner.png)
This repository is used to demonstrate how to use the preference module in android with multi modularity


<p align="center">
<a><img src="https://img.shields.io/badge/Kotlin--Dsl-For--Dependencies-red"></a>
<a><img src="https://img.shields.io/badge/Hilt-Dependency%20Injection-green"></a>
<a><img src="https://img.shields.io/badge/Architecture-Clean%20Architecture-pink"></a>
<a><img src="https://img.shields.io/badge/Jetpack-Data%20Store-blue"></a>
<a><img src="https://img.shields.io/badge/Store%20Data-Shared%20Preferences-purple"></a>
<a><img src="https://img.shields.io/badge/Structure-Multi%20Module-magenta"></a>
</p>


---
![Banner](https://github.com/devrath/droid-preference-module/blob/main/assets/block_diagram.drawio.png)

---

## What is a preference module
* We use the preference module to store `key/value` pairs in android. 
* These are data that are small that dosen't need a local database but needed to be stored so that htey can be retrieved later after app kill and relaunch.

## Challenges usually we face in a large project 
* Sometimes whent the code repository is large and there are lot of developers have worked on the same piece of code the shared preference API is directly refered in the `view-model` , `activity`, `fragment`. 
* This reduces the testability of the project.

## Improving the structuring 
* Having the clean architecture reduces lot of problems by decoupling the code.
* Using the `dependency injection` also helps in promoting code towards modularity and makes life much simpler by generating the code behind the scenes so that android developer dosen't have to spend writing that code and can focus on code structure more.

## Using shared preference with proper pattern
* Rather than directly calling the `shared preference` library we should call a interfce and inturn implementtion is called by class that implements the interface
* Using this its easier to decople the entire `preference-logic` and say tomorrow if needed we can migrate to a different implementation(this is demonstrated in the project also by migrating from shared preferences to data store)

---
#### What is Data Store
* Datastore is a component of data storage solution from the android jetpack.
* It allows us to store the `key/value` pairs like shared preferences or typed objects with protocol buffers.
* Data store uses kotlin, coroutines, and flow to store data asynchronously with consistency and transaction support

#### Why use datastore when we already have shared preferences
* `Shared Preferences` are `synchronous` and not main thread-safe, But data store is safe to use in the main thread since it uses `Dispatchers.IO` under the hood.
* `Shared Preferences` are not safe from runtime exceptions, But the `Data-Store` is safe from runtime exceptions
* There is an easy way to migrate from `Shared Preferences`


### About the project
* We have a three screen project which is multimodular in nature
* Forst screen we select whetehr we want to save the data usin g `shared preferences` or `data store` 
* As shown in demo we save the data in `shared preferences` and then we migrate into the `data store` and then edit into a new data and save it again using `data-store`

### Demo preview of project 
<p align="center">
<a><img src="/assets/recording.gif" width="320" height="660"/></a>
</p>

<p align="center">
<a><img src="https://forthebadge.com/images/badges/built-for-android.svg"></a>
</p>
