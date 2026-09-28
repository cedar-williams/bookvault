


# CI
* On push and pull request: Run maven tests
* Todo: On push to release branch: Build .jar release

# Design Decisions
* **Date Of Publishing**: 
  Some books have a published date of a year, some are more precise with a day and month.
  Currently, I have this represented as a LocalDate object, which specifies all 3.
  Because of this, for the time being I will represent works and editions without a month or day as being published Jan 1st of the specified year.