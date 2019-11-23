# -*- coding: utf-8 -*-
import string
import sys

import text_analyzer
import text_maker


def main():
    text_file_name: string = sys.argv[1]
    dictionary_path = text_analyzer.analyze_csv_by_markov(text_file_name)
    tweet_content = text_maker.make_sentence_from_json_dictionary(dictionary_path)

    print(tweet_content)


if __name__ == "__main__":
    main()
