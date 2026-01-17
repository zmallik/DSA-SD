
# DROPBOX /  FILE STORAGE SYSTEM

- pre-signed urls

1) How can you support large files?
```
50GB => (50 * 80)/100 = 4000 sec (100 Mbps connection) = 1 hour. 11 ssec
chunking
Amazon s3 multipart upload
we can also utilize compression to speed up both uploads and downloads
```
