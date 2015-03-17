## Remove API baseline warning ##
> The status of all UNICASE projects should be warning free. In case you encounter the warning "An API baseline has not been set for the current workspace" you can disable this type of warning.


<br>
<br>
<blockquote><img src='http://unicase.googlecode.com/files/6bc46.png' />
<br>
<br></blockquote>

<blockquote>In order to do this, you go to your Eclipse Preferences and then select Plug-In Development/API baselines. Here you can set an API baseline or set missing API baseline to Ignore. An API baseline defines an eclipse API against which your code is compared and checked for compatibility (for example against @notextend or @since annotations). To set an API base line, click on Add Baseline... and in New API Baseline dialog select the path to eclipse installation you intend to use as your baseline.</blockquote>

<br>
<br>
<blockquote><img src='http://unicase.googlecode.com/files/aa942.png' />
<br>
<br>
</blockquote><blockquote>Rebuild the project afterward.