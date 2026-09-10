# ISS Tracker

A small web app that plots the International Space Station's position on Google Maps. Built with HTML, CSS, JavaScript, and jQuery, it fetches coordinates from the Open Notify API and recenters the map as the station moves.

## Features

- Updates the station's position approximately every six seconds.
- Displays a countdown until the next update.
- Uses a satellite marker and a custom dark map style.

## Setup

1. Obtain a Google Maps API key for the Maps JavaScript API.
2. Add your key to `js/token.js`:

   ```javascript
   var googleMapApiToken = "YOUR_GOOGLE_MAPS_API_KEY";
   ```

3. Serve this folder with a local web server and open `index.html` in your browser.

This archived project uses an HTTP endpoint for ISS coordinates. Hosting the page over HTTPS may cause the browser to block those requests as mixed content.

## Customization

Edit the `mapStyle` array in `js/mapstyle.js` to change the map's appearance.

## Resources and Credits

- [Google Maps](https://developers.google.com/maps/)
- [Open Notify ISS position API](http://api.open-notify.org/iss-now.json)
- [jQuery](https://jquery.com/)
- [Satellite icon by Squid.ink](https://www.iconfinder.com/Squid.ink)
