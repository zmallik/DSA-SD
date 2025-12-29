“How would you design a 𝗟𝗼𝗴 𝗔𝗴𝗴𝗿𝗲𝗴𝗮𝘁𝗼𝗿 like ELK (Elasticsearch, Logstash, Kibana)?”

Here’s how to approach it:

First, identify the scale. If you have hundreds of microservices, you can’t have them all writing logs to a central database synchronously; it would crash the app if the log store is slow.

Start with an 𝗔𝗴𝗲𝗻𝘁-𝗯𝗮𝘀𝗲𝗱 𝗺𝗼𝗱𝗲𝗹. Each server runs a small 'shipper' (like Filebeat) that reads local log files and pushes them to a buffer. This decouples the application's performance from the logging infrastructure.

Use a 𝗠𝗲𝘀𝘀𝗮𝗴𝗲 𝗕𝗿𝗼𝗸𝗲𝗿 (like Kafka) as a buffer. If your log processing pipeline goes down or gets overwhelmed by a sudden traffic spike, the logs aren't lost—they sit safely in the queue until the processors catch up.

Now, for the advanced point: discuss 𝗜𝗻𝗱𝗲𝘅 𝗠𝗮𝗻𝗮𝗴𝗲𝗺𝗲𝗻𝘁 and 𝗥𝗲𝘁𝗲𝗻𝘁𝗶𝗼𝗻 𝗣𝗼𝗹𝗶𝗰𝗶𝗲𝘀. Storing every log forever is too expensive. (If you mention this, it will make you stand out from other candidates.) Suggest a "Hot-Warm-Cold" architecture where recent logs are on fast SSDs for quick searching, and older logs are moved to cheaper storage (like S3) before being deleted.
