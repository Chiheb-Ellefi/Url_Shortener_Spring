local hash = KEYS[1]
local url = ARGV[1]
local clicks = ARGV[2]
local full_url = tostring(clicks) .. ":" .. url
redis.call("SET", hash, full_url)
local all_urls=redis.call("GET","urls")
if not all_urls then
    redis.call("SET", "urls",hash)
else
    all_urls=all_urls..':'..hash;
    redis.call("SET", "urls", all_urls)
end
return hash
