import { For, refkey } from "@alloy-js/core";
import * as ts from "@alloy-js/typescript";
import { useTsp } from "@typespec/emitter-framework";
import * as ef from "@typespec/emitter-framework/typescript";
import { useClientLibrary } from "@typespec/http-client";
import { getFileTypeReference } from "./static-helpers/multipart-helpers.jsx";

export interface ModelsProps {
  path?: string;
}

export function Models(props: ModelsProps) {
  const { $ } = useTsp();
  const clientLibrary = useClientLibrary();
  const dataTypes = clientLibrary.dataTypes;
  return (
    <ts.SourceFile path={props.path ?? "models.ts"}>
      <For each={dataTypes} joiner={"\n"} hardline>
        {(type) => {
          if ($.model.is(type) && $.model.isHttpFile(type)) {
            return (
              <ts.TypeDeclaration name="File" export kind="type" refkey={refkey(type)}>
                {getFileTypeReference()}
              </ts.TypeDeclaration>
            );
          }
          return $.array.is(type) || $.record.is(type) ? null : (
            <ef.TypeDeclaration export type={type} />
          );
        }}
      </For>
    </ts.SourceFile>
  );
}
