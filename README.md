# Pixels Against Humanity

An Apraxis example app that lets you play Cards Against Humanity online
with all sorts of screen sizes.

## Design/ front-end static development

This uses [middlemanapp](http://middlemanapp.com), a static site
generator. jRuby 1.7.17 is required.

To run middleman and make templates/styles:

```
gem install bundler
bundle install
bundle exec middleman
```

Then visit [localhost:4567](http://localhost:4567) in your browser.

Documentation for languages/frameworks in use:

* [middleman](http://middlemanapp.com); Ruby static site generator
* [Sass](http://sass-lang.com); CSS preprocessor in use (SCSS syntax)
* [Compass](http://compass-style.org); CSS authoring framework
* [Susy 2](http://susy.oddbird.net/); Grid math @includes
* [Breakpoint](http://breakpoint-sass.com/); @media-query @includes
* [HAML](http://haml.info/); Less verbose than HTML templating

