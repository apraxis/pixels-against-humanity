###
# Set some directory stuff up for middleman to know what's happening
###

set :source, 'src'
set :css_dir, 'style'
set :images_dir, 'images'
set :layouts_dir, 'structure/layouts'

###
# Compass
###

# Change Compass configuration
compass_config do |config|
  require 'breakpoint'
  config.output_style = :compact
end

###
# Page options, layouts, aliases and proxies
###

# Per-page layout changes:
#
# With no layout
# page "/path/to/file.html", :layout => false
#
# With alternative layout
# page "/path/to/file.html", :layout => :otherlayout
#
# A path which all have the same layout
# with_layout :admin do
#   page "/admin/*"
# end

activate :directory_indexes

# Proxy pages (http://middlemanapp.com/basics/dynamic-pages/)
# proxy "/this-page-has-no-template.html", "/template-file.html", :locals => {
#  :which_fake_page => "Rendering a fake page with a local variable" }

###
# Helpers
###

# Automatic image dimensions on image_tag helper
# activate :automatic_image_sizes

# Reload the browser automatically whenever files change
# configure :development do
#   activate :livereload
# end

# Methods defined in the helpers block are available in templates
# helpers do
#   def some_helper
#     "Helping"
#   end
# end

###
# Extensions
###

# https://github.com/middleman/middleman-syntax
activate :syntax, line_numbers: true

set :markdown_engine, :kramdown
set :markdown, :fenced_code_blocks => true, :smartypants => true

# Build-specific configuration
configure :build do
  activate :minify_css
  activate :minify_javascript
  activate :gzip

  ignore 'structure/layouts*'
  # Enable cache buster
  # activate :asset_hash

  # Use relative URLs
  # activate :relative_assets

  # Or use a different image path
  # set :http_prefix, "/Content/images/"
end
