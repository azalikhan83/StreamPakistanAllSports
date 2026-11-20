# STREAM PAKISTAN ALL SPORTS

Minimal Android Java project with Cloudflare D1 Worker channel list integration.

## Build
Push files to the repository root, then use GitHub Actions > Build Stream Pakistan APK > Run workflow.
The APK appears under Artifacts when the job succeeds.

## Note
The current Worker `/api/channels` response returns channel metadata but **not stream_url**, so video playback will remain unavailable until a safe authorized playback API is added. The WebView only loads HTTPS webpages and is not an HLS native player. Do not add unauthorized TV streams. This is a starter project, not a complete commercial streaming platform.
