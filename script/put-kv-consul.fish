#!/usr/bin/env fish

function put_consul
  argparse -n put_consul 'h/help' -- $argv
  or return 1

  if set -lq _flag_help
    echo "put-consul.fish: Put server.port to Consul as Destributed Configuration"
    return
  end
  curl \
      --request PUT \
      --data 0 \
      http://127.0.0.1:8500/v1/kv/config/frontend-service/server.port
end

put_consul $argv
