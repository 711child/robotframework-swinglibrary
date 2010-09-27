#!/usr/bin/ruby

args = ARGV.join(" ")
ARGV.clear

require 'rubygems'
require 'buildr'

module Buildr
  class Application
    def rakefile
      __FILE__
    end
  end
end

def root_dir
  this_dir = Dir.pwd
  until File.directory? "#{Dir.pwd}/core"
    Dir.chdir('..')
  end
  root = Dir.pwd
  Dir.chdir(this_dir)
  root
end

require "#{root_dir}/lib/dependencies"

deps = ["#{root_dir}/core/target/classes",
        "#{Dir.pwd}/../../../../target/classes",
        Buildr.artifacts(DEPENDENCIES),
        Buildr.artifacts(TEST_DEPENDENCIES)].flatten

deps.each do |dep|
  raise "#{dep} doesn't exist" unless File.exist? dep.to_s
end

ENV['CLASSPATH'] = deps.join(":")

system "jybot --loglevel TRACE --outputdir /tmp --noncritical development --tagstatcombine *NOTdevelopment:regression #{args}"
